package springbatchplay

import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext

class PrintStartMessageTasklet implements Tasklet {

    RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        println "Starting Job"
        return RepeatStatus.FINISHED
    }
}
