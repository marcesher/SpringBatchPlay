package springbatchplay

import org.springframework.batch.item.ItemWriter


class ModelItemWriter implements ItemWriter {
    void write(List ts) {
        println "Inside ModelItemWriter"
        ts.each {
            println "ItemWriter: Looking at $it"
            println it.dump()
            it.save(flush:true)
        }
    }
}
