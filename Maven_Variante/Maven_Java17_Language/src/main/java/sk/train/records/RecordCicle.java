package sk.train.records;

record RecordCicle(int x, Record2 r) {
	
	RecordCicle(int x, Record2 r){
		this.x = 1;
		this.r = null;
	}
}


record Record2(int x, RecordCicle r) {

}