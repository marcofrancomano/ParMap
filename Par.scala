//  Author:         (c) 2021 Bonifacio Marco Francomano


object Par {
	def par[A,B,C,D](a: =>A)(b: =>B)(c: =>C)(d: =>D) = {
		var resA:Option[A] = None
		val r = new Runnable {
			def run() = {
				resA = Some(a)
			}
		}
		var resC:Option[C] = None
		val r2 = new Runnable {
			def run() = {
				resC = Some(c)
			}
		}
		var resD:Option[D] = None
		val r3 = new Runnable {
			def run() = {
				resD = Some(d)
			}
		}
		val t = new Thread(r)
		val t2 = new Thread(r2)
		val t3 = new Thread(r3)
		t.start()
		t2.start()
		t3.start()
		val resB = b
		t.join()
		t2.join()
		t3.join()
		(resA.get,resB,resC.get,resD.get)
	}
}
