package sexample.study.secondhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

private const val INVITE_KEY="ПРИВЕТ"

class MainActivity : AppCompatActivity() {

    // инициализация кнопки перехода на 2ую Активити
    lateinit var withLinkActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // actionBar?.title="ВСЕЛЕННАЯ РОМАНА"

        // поиск кнопки перехода на 2ую Активити по id
        withLinkActivityButton=findViewById(R.id.second_activity_button)

        // повесить Слушателя на кнопку перехода
        withLinkActivityButton.setOnClickListener {
            // эта переменная хранит в себе Интент перехода на след.Активити
            val withLinkActivityIntent:Intent= Intent(this, WithLinkActivity::class.java)
            // поместим текст из кнопки в текстовью 2й Активити
            withLinkActivityIntent.putExtra(INVITE_KEY, "ПРИГЛАШАЮ НА МОЙ САЙТ")
            // запуск этого Интента
            startActivity(withLinkActivityIntent)
        }
    }
}