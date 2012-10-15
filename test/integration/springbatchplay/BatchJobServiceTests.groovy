package springbatchplay

import static org.junit.Assert.*
import org.junit.*

class BatchJobServiceTests {

    def batchJobService

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testJobLauncher() {
        batchJobService.launchSimpleJob()
    }
}
