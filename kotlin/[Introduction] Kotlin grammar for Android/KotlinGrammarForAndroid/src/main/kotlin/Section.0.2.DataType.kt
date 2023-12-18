//1.DataType : Kotlin has 7 series of DataType.
//  1.1.number(4series) : int, Long, Double, Float
//  1.2.String : String
//  1.3.boolean : true, false

//2.DataType Cost

//3.null type

fun main(){
    // must separate number and string when programming
    val test1 = "1234" //String
    val test2 = 1234   //number(int)
    println(test1 + 1) //12341
    println(test2 + 1) //1235

    val test3 = 1234.1234 //number(double)

    //print the data types of variables.
    println("Data type of test1 : "+ test1::class.java.simpleName)
    println("Data type of test2 : "+ test2::class.java.simpleName)
    println("Data type of test3 : "+ test3::class.java.simpleName)

    //Set the data type.
    val test4 : Int = 1234
    println("test4 : "+ test4)

    //Data type mismatch.
    //val test5 : Int = "1234" //Kotlin: Type mismatch: inferred type is String but Int was expected

    //
    //val test6 : Int = 1234.1234 //Kotlin: The floating-point literal does not conform to the expected type Int
    //println(test5 )


}

