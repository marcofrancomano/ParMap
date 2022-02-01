//  Author:         (c) 2021 Bonifacio Marco Francomano
//I have chosen to set a minimum range such that the parallel version is convenient over the sequential one
//This version is implemented with 4 threads

object ParMain extends App{
	val start = System.nanoTime
	var l:List[Int]=(1 to 100000).toList
	val f:Int=>Boolean =  o => l contains o+1
	val s:List[Boolean]=ParMap.map(l,f)
	val t = System.nanoTime - start
	//println("final result of the parallel version: " +s)
	println("time taken by the parallel version: "+t +"ns")
	
	
	//println(l)
	
	val start2 = System.nanoTime
	val g:List[Boolean]=l.map(f)
	val t2 = System.nanoTime - start2
	//println("final result of the sequential version: " +g)
	println("time taken by the sequential version: "+t2+"ns")
	
}
