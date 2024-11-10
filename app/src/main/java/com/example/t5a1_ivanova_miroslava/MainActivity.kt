package com.example.t5a1_ivanova_miroslava

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5a1_ivanova_miroslava.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var comidaAdaptador: ComidaAdaptador
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comidaAdaptador = ComidaAdaptador(getComidas(), this)
        linearLayoutManager = LinearLayoutManager(this)
        itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        binding.recyclerview.apply {
            layoutManager = linearLayoutManager
            adapter = comidaAdaptador
            addItemDecoration(itemDecoration)
        }

    }

    private fun getComidas(): MutableList<Comida> {
        val comidas = mutableListOf<Comida>()

        val paella = Comida(
            "Paella",
            "España",
            "https://upload.wikimedia.org/wikipedia/commons/4/4e/Paella_kamilo.jpg",
            "https://es.wikipedia.org/wiki/Paella"
        )
        val sushi = Comida(
            "Sushi",
            "Japón",
            "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/53f59ee3-60ce-4d32-8885-c6f05457259c/dgnsjzt-562d33a9-699d-48ac-b791-5615ad37e5f1.jpg/v1/fill/w_400,h_400,q_75,strp/salmon_sushi_japanese_food_ingredients_ai__13__by_anavrin_ai_dgnsjzt-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzUzZjU5ZWUzLTYwY2UtNGQzMi04ODg1LWM2ZjA1NDU3MjU5Y1wvZGduc2p6dC01NjJkMzNhOS02OTlkLTQ4YWMtYjc5MS01NjE1YWQzN2U1ZjEuanBnIiwiaGVpZ2h0IjoiPD00MDAiLCJ3aWR0aCI6Ijw9NDAwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLndhdGVybWFyayJdLCJ3bWsiOnsicGF0aCI6Ilwvd21cLzUzZjU5ZWUzLTYwY2UtNGQzMi04ODg1LWM2ZjA1NDU3MjU5Y1wvYW5hdnJpbi1haS00LnBuZyIsIm9wYWNpdHkiOjk1LCJwcm9wb3J0aW9ucyI6MC40NSwiZ3Jhdml0eSI6ImNlbnRlciJ9fQ.GIf2BgJZJtm7XL2cQqEXp_Tzc3qH4g-xUMVrjmQUx3c",
            "https://es.wikipedia.org/wiki/Sushi"
        )
        val pizza = Comida(
            "Pizza",
            "Italia",
            "https://upload.wikimedia.org/wikipedia/commons/9/91/Pizza-3007395.jpg",
            "https://es.wikipedia.org/wiki/Pizza"
        )
        val tacos = Comida(
            "Tacos",
            "México",
            "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/9f8ff910-682c-4633-9b11-1a9e5c973d97/dfxvdjm-3b130623-a899-411b-b3bd-16335c5755ae.jpg/v1/fill/w_1280,h_1067,q_75,strp/tacos_by_infopablo00_dfxvdjm-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTA2NyIsInBhdGgiOiJcL2ZcLzlmOGZmOTEwLTY4MmMtNDYzMy05YjExLTFhOWU1Yzk3M2Q5N1wvZGZ4dmRqbS0zYjEzMDYyMy1hODk5LTQxMWItYjNiZC0xNjMzNWM1NzU1YWUuanBnIiwid2lkdGgiOiI8PTEyODAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.S3rc8c7t1W5sC698s4eI9sHbq1KPUGyWxaAvqFxFJyw",
            "https://es.wikipedia.org/wiki/Taco"
        )
        val fishchips = Comida(
            "Fish and Chips",
            "England",
            "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/53f59ee3-60ce-4d32-8885-c6f05457259c/dgxzmlj-6c486762-a448-4e91-9053-d00ac2fa2405.jpg/v1/fill/w_600,h_343,q_75,strp/fish_and_chips_advertisement_food_photography__9__by_anavrin_ai_dgxzmlj-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzUzZjU5ZWUzLTYwY2UtNGQzMi04ODg1LWM2ZjA1NDU3MjU5Y1wvZGd4em1sai02YzQ4Njc2Mi1hNDQ4LTRlOTEtOTA1My1kMDBhYzJmYTI0MDUuanBnIiwiaGVpZ2h0IjoiPD0zNDMiLCJ3aWR0aCI6Ijw9NjAwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLndhdGVybWFyayJdLCJ3bWsiOnsicGF0aCI6Ilwvd21cLzUzZjU5ZWUzLTYwY2UtNGQzMi04ODg1LWM2ZjA1NDU3MjU5Y1wvYW5hdnJpbi1haS00LnBuZyIsIm9wYWNpdHkiOjk1LCJwcm9wb3J0aW9ucyI6MC40NSwiZ3Jhdml0eSI6ImNlbnRlciJ9fQ.-L8gm-OYHoMy1Hhom9gvALL5ICeJa56uc0PU9cW77fs",
            "https://es.wikipedia.org/wiki/Fish_and_chips"
        )
        val curry = Comida(
            "Curry",
            "India",
            "https://cdn.prod.website-files.com/6549128db41d15ae06784cbc/6644ab9937bf50fdaa8c99fa_Butter%20Chicken.webp",
            "https://es.wikipedia.org/wiki/Curry"
        )
        val feijoada = Comida(
            "Feijoada",
            "Brasil",
            "https://live.staticflickr.com/3913/14250860719_3acd42b71f_b.jpg",
            "https://es.wikipedia.org/wiki/Feijoada"
        )

        comidas.add(paella)
        comidas.add(sushi)
        comidas.add(pizza)
        comidas.add(tacos)
        comidas.add(fishchips)
        comidas.add(curry)
        comidas.add(feijoada)

        return comidas

    }

    override fun onClick(comida: Comida) {
        Toast.makeText(this, comida.nombre, Toast.LENGTH_LONG)
    }


}
