package com.example.bts_lecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.프로그램이 유저에 의해 화면이 클릭되었다는 것을 사실을 알아야 한다.
        //  (강의명 : 화면 클릭 이벤트 처리 - findViewById, Toast)
        val image1 = findViewById<ImageView>(R.id.btsImage1) //val 변수에 클릭된 이미지(btsImage1)를 삽입한다.
        image1.setOnClickListener{
            Toast.makeText(this, "1번 이미지 클릭 완료", Toast.LENGTH_LONG).show() //Toast 메세지가 출력된다.

            //2. 화면이 클릭되면 다음화면으로 넘어가서 사진을 크게 보여주는 이벤트를 실시한다.
            //  (강의명 : 화면(액티비티) 새로 만들기, 화면전환(intent) )
            val intent = Intent(this, Bts1Activity::class.java)
            startActivity(intent)
        }

        //3. 나머지 6개의 이미지들도 동일한 처리를 만들어준다.
        val image2 = findViewById<ImageView>(R.id.btsImage2) //val 변수에 클릭된 이미지(btsImage1)를 삽입한다.
        image2.setOnClickListener{
            Toast.makeText(this, "2번 이미지 클릭 완료", Toast.LENGTH_LONG).show() //Toast 메세지가 출력된다.

            val intent = Intent(this, Bts2Activity::class.java)
            startActivity(intent)
        }

        val image3 = findViewById<ImageView>(R.id.btsImage3) //val 변수에 클릭된 이미지(btsImage1)를 삽입한다.
        image3.setOnClickListener{
            Toast.makeText(this, "3번 이미지 클릭 완료", Toast.LENGTH_LONG).show() //Toast 메세지가 출력된다.

            val intent = Intent(this, Bts3Activity::class.java)
            startActivity(intent)
        }

        val image4 = findViewById<ImageView>(R.id.btsImage4) //val 변수에 클릭된 이미지(btsImage1)를 삽입한다.
        image4.setOnClickListener{
            Toast.makeText(this, "4번 이미지 클릭 완료", Toast.LENGTH_LONG).show() //Toast 메세지가 출력된다.

            val intent = Intent(this, Bts4Activity::class.java)
            startActivity(intent)
        }

        val image5 = findViewById<ImageView>(R.id.btsImage5) //val 변수에 클릭된 이미지(btsImage1)를 삽입한다.
        image5.setOnClickListener{
            Toast.makeText(this, "5번 이미지 클릭 완료", Toast.LENGTH_LONG).show() //Toast 메세지가 출력된다.

            val intent = Intent(this, Bts5Activity::class.java)
            startActivity(intent)
        }

        val image6 = findViewById<ImageView>(R.id.btsImage6) //val 변수에 클릭된 이미지(btsImage1)를 삽입한다.
        image6.setOnClickListener{
            Toast.makeText(this, "6번 이미지 클릭 완료", Toast.LENGTH_LONG).show() //Toast 메세지가 출력된다.

            val intent = Intent(this, Bts6Activity::class.java)
            startActivity(intent)
        }

        val image7 = findViewById<ImageView>(R.id.btsImage7) //val 변수에 클릭된 이미지(btsImage1)를 삽입한다.
        image7.setOnClickListener{
            Toast.makeText(this, "7번 이미지 클릭 완료", Toast.LENGTH_LONG).show() //Toast 메세지가 출력된다.

            val intent = Intent(this, Bts7Activity::class.java)
            startActivity(intent)
        }

    }
}