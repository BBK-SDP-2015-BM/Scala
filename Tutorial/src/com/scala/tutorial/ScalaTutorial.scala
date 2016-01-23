package com.scala.tutorial

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Basil on 23/01/2016.
  */
object ScalaTutorial {

  def main(args: Array[String]) {

    var i = 0

    while(i <= 10) {
      println(i)
      i += 1
    }

    for(i <- 1 until 10)
      println(i)

    // create lists
    var evenList = for { i <- 1 to 10 if (i%2) == 0} yield i

    // nested loops
    for(i<-1 to 5; j<-6 to 10)
      println(i)

    def sayHi : Unit = {
      println("Hello")
    }

    sayHi

    // Arrays

    val nums = new Array[Int](20)

    val friends = Array("Basil", "Reb")

    println(friends(0))

    val friends2 = ArrayBuffer[String]()
    friends2.insert(0, "Basil", "Dan")
    friends2 += "Reb"
    friends2 ++= Array("Liz", "Andy")

    for(friend<-friends2)
      println(friend)

    for (j <- 0 to nums.length - 1) {
      nums(j) = j
      println(j)
    }

    val numsTimesTwo = for(num <- nums) yield 2*num

    numsTimesTwo.foreach(println)

    val numsDivTwo = for(num <- nums if num % 4 == 0) yield num

    // multidimensional arrays

    var multi = Array.ofDim[Int](10,10)

    // array functions

    nums.sum
    nums.max

    val sortedNums = nums.sortWith(_>_)

    println(sortedNums.deep.mkString(", "))

    // Maps

    // immutable
    val people = Map("Manager" -> "Me", "Worked" -> "Someone")

    // mutable
    val customer = collection.mutable.Map(100 -> "Pal")

    if (people.contains("Manager"))
      println(people("Manager"))

    // print map
    for((k,v) <-customer)
      printf("%d : %s\n", k, v)

    // tuple
    val tuple = (1, "me", 90.00)
    println(tuple._2)

    // objects
    val rover = new Animal("Dog", "Woof")


  }


  // default constructor at class level
  // no static methods
  class Animal(var name : String, var sound : String) {

    // other constructor
    def this(name : String) {
      this(name, "sound")
    }

    // override
    override def toString() : String = {
      return "%s string: ".format(this.name)
    }
  }

  // companion object (for static details)
  object Animal {
    private var idNumber = 0
    private def newId {idNumber +=1; idNumber}
  }

  class Dog(name: String, sound: String) extends Animal(name, sound){

  }

  trait Flyable {
    def fly : String
  }

}
