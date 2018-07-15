package com.danielkeresztes.books

import com.danielkeresztes.books.network.BookService
import com.danielkeresztes.books.repository.BookRepository
import com.danielkeresztes.books.vo.VolumeResponse
import io.reactivex.observers.TestObserver
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

@RunWith(JUnit4::class)
class BookServiceTest {

    val testObserver = TestObserver<VolumeResponse>()
    private lateinit var service: BookService
    private lateinit var mockWebServer: MockWebServer
    private lateinit var bookRepository: BookRepository

    @Before
    fun createService() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(BookService::class.java)
        bookRepository = BookRepository(service)
    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }

    @Test
    fun search() {
        val mockReponse = MockResponse()
                .setResponseCode(200)
                .setBody(getJson("api-response/search.json"))
        mockWebServer.enqueue(mockReponse)
        bookRepository.loadBookList().subscribe(testObserver)

        val request = mockWebServer.takeRequest()
        assertThat(request.path, `is`("/volumes?q=software&maxResults=40"))
        testObserver.assertNoErrors().assertValue { response: VolumeResponse -> response.items[0].volumeInfo.title == "Cutting Code" }
                .assertValue {  response: VolumeResponse -> response.items[0].volumeInfo.publisher == "Peter Lang" }
    }

    fun getJson(path : String) : String {
        val uri = this.javaClass.classLoader.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}
