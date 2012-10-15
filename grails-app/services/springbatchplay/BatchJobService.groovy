package springbatchplay

import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.Job

class BatchJobService {

    def jobLauncher
    def simpleJob

    public void launchSimpleJob() {
        jobLauncher.run(simpleJob,
                new JobParametersBuilder().addDate("date", new Date()).toJobParameters()
        )
    }
}
