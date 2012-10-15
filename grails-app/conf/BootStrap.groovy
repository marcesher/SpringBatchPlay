import springbatchplay.TableOne

class BootStrap {

    def init = { servletContext ->

        if( ! TableOne.count() ){
            new TableOne(one:  'Marc', two:  1.1, anInt: 5).save(flush: true)
        }

    }
    def destroy = {
    }
}
