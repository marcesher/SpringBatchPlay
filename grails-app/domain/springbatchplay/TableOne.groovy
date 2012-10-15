package springbatchplay

class TableOne {

    static constraints = {
    }

    static mapping = {
        table 'TABLE_ONE'
        anInt column : 'ANINT'
        one column : 'ONE'
        two column: 'TWO'
    }

    String one
    Double two
    Integer anInt

    def setOne(String one){
        println "inside setOne"
        this.one = one
    }
}
