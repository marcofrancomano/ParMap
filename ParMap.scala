//  Author:         (c) 2021 Bonifacio Marco Francomano



import Par._



object ParMap{
	def map[T,S](l:List[T],f:T=>S) = {
		val (a,b)=l.splitAt(l.size/2)
		val (c,d)=a.splitAt(l.size/2)
		val (e,f1)=b.splitAt(l.size/2)
		val(mc,md,me,mf) = par { // definizione del body dei side effect ma ed mb (par è currificato)
			c.map(f)
		}
		{
			d.map(f)
		}
		{
			e.map(f)
		}
		{
			f1.map(f)
		}
		mc:::md:::me:::mf
	}
}


