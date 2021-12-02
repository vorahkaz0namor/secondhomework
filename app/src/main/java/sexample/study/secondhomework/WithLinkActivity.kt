package sexample.study.secondhomework

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val INVITE_KEY="ПРИВЕТ"

class WithLinkActivity : AppCompatActivity() {

    lateinit var copiedText: TextView
    // инициализация кнопки перехода в браузер
    lateinit var goToLinkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_link)

        // находим по id тектвью, в который надо переместить текст из главной Активити
        copiedText=findViewById(R.id.copied_text)
        // получаем данные из Интента
        val copiedValue: String? = intent.extras?.getString(INVITE_KEY)
        // подставляем скопированный текст в текствью 2й Активити
        copiedText.text = copiedValue

        // поиск кнопки перехода в браузер по id
        goToLinkButton=findViewById(R.id.go_to_link_button)

        // повесить Слушателя на кнопку перехода в браузер
        goToLinkButton.setOnClickListener {
            // переменная copiedTextToUri преобразует ссылку в тип Uri
            val copiedTextToUri = Uri.parse("http://komavp.12-t.ru/")
            // переменная openBrowserIntent отправляет ссылку в браузер
            val openBrowserIntent: Intent = Intent(Intent.ACTION_VIEW,copiedTextToUri)
            // создаем выборщика
            val chooser = Intent.createChooser(openBrowserIntent, "Browser")
            // запуск этого Интента
            startActivity(chooser)
        }
    }
}