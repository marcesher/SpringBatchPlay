package springbatchplay

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.core.io.Resource


class DebugItemReader extends FlatFileItemReader {

    void setResource( Resource resource ){
        println resource.file.absolutePath
       this.resource = resource
    }

}
