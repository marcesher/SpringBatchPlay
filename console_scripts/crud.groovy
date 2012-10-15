import springbatchplay.*


def t = new TableOne(one: 'myname', two : 1.2, anInt : 5)
t.save(flush:true)


def list = TableOne.list()
list