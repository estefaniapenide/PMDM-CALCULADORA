package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //Calculadora
    var numero = 0.0
    var resultado = 0.0
    var total=0.0
    var signo=""

    fun suma(resultado: Double, numero: Double): Double {
        return resultado + numero }

    fun resta(resultado: Double, numero: Double): Double {
        return resultado - numero}

    fun mult(resultado: Double, numero: Double): Double {
        return resultado * numero}

    fun div(resultado: Double, numero: Double): Double {
        return resultado / numero}

    fun operacion(resultado: Double, numero: Double, signo: String): Double {
        when (signo) {
            "+" -> total = suma(resultado, numero)
            "-" -> total = resta(resultado, numero)
            "x" -> total = mult(resultado, numero)
            "/" -> total = div(resultado, numero)
            else -> {
                total=34404.0
            }
        }
        return total
    }

    fun reasignacion(total:Double){
        resultado=total
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Mirar esto para no tener que inicializarla así y poder usar el if de escribir número (ahora no me funciona)
        binding.tvNumero.text=""
        var texto = binding.tvNumero.getText().toString()
        var textoSegundoPlano=""

        var signoNuevo=""

        fun escribirNumero(digito:String): String{
            if (texto.equals("0")){
                binding.tvNumero.text=""
            }
            texto+=digito
            binding.tvNumero.text=texto

            return texto
        }

        fun elegirOperacion(operacion:String){
            texto=operacion
            binding.tvNumero.text=texto
            signo=operacion
        }

        fun igual(){
            reasignacion(operacion(resultado,numero,signo))
            texto="="+resultado.toString()
            binding.tvNumero.text=texto
        }


        fun guardarNumero(){
            if(resultado==0.0){
                resultado=texto.toDouble()
            }else {
                numero = texto.toDouble()
            }
        }

        fun pasarTextoSegundoPlano(texto:String){
            textoSegundoPlano+=texto
            binding.tvOperacion.text=textoSegundoPlano
        }

        fun borrarTexto(){
            binding.tvNumero.text=""
            texto=binding.tvNumero.text.toString()

        }

        fun reinicio(){
            resultado=0.0
            numero=0.0
            texto=""
            textoSegundoPlano=""
            binding.tvNumero.text=texto
            binding.tvOperacion.text=textoSegundoPlano
        }


        binding.b0.setOnClickListener{
            escribirNumero("0")
        }

        binding.b1.setOnClickListener{
            escribirNumero("1")
        }

        binding.b2.setOnClickListener{
            escribirNumero("2")
        }

        binding.b3.setOnClickListener{
            escribirNumero("3")
        }

        binding.b4.setOnClickListener{
            escribirNumero("4")
        }

        binding.b5.setOnClickListener{
            escribirNumero("5")
        }

        binding.b6.setOnClickListener{
            escribirNumero("6")
        }

        binding.b7.setOnClickListener{
            escribirNumero("7")
        }

        binding.b8.setOnClickListener{
            escribirNumero("8")
        }

        binding.b9.setOnClickListener{
            escribirNumero("9")
        }

        binding.bmasmenos.setOnClickListener{}
        binding.bcoma.setOnClickListener{
            escribirNumero(".")
        }

        binding.bigual.setOnClickListener{
            pasarTextoSegundoPlano(texto)
            guardarNumero()
            igual()
        }


        binding.bmas.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano(texto)
            borrarTexto()
            elegirOperacion("+")
        }

        binding.bmenos.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano(texto)
            borrarTexto()
            elegirOperacion("-")
        }

        binding.bmult.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano(texto)
            borrarTexto()
            elegirOperacion("x")
        }

        binding.bdiv.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano(texto)
            borrarTexto()
            elegirOperacion("/")
        }

        binding.braiz2.setOnClickListener{}
        binding.bpotencia2.setOnClickListener{}
        binding.binverso.setOnClickListener{}
        binding.bporcentaje.setOnClickListener{}

        binding.bdel.setOnClickListener{}
        binding.bc.setOnClickListener{}
        binding.bce.setOnClickListener{
            reinicio()
        }
    }


}