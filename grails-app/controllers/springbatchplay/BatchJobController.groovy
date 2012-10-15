package springbatchplay

class BatchJobController {

    def batchJobService

    def index() { }

    def run() {
        println "Launching simple job"
        batchJobService.launchSimpleJob()
        println "Simple Job Launched"
    }
}
