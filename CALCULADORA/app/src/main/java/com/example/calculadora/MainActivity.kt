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
    var total = 0.0
    var signo="+"

    fun suma(resultado: Double, numero: Double): Double {
        return resultado + numero
    }

    fun resta(resultado: Double, numero: Double): Double {
        return resultado - numero
    }

    fun mult(resultado: Double, numero: Double): Double {
        return resultado * numero
    }

    fun div(resultado: Double, numero: Double): Double {
        return resultado / numero
    }

    fun operacion(resultado: Double, numero: Double, signo: String): Double {
        when (signo) {
            "+" -> total = suma(resultado, numero)
            "-" -> total = resta(resultado, numero)
            "x" -> total = mult(resultado, numero)
            "/" -> total = div(resultado, numero)
            else -> {
                total = 444444.0
            }
        }
        return total
    }

    fun reasignacion(total: Double) {
        resultado = total
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Mirar esto para no tener que inicializarla así y poder usar el if de escribir número (ahora no me funciona)
        binding.tvNumero.text=""
        var texto=binding.tvNumero.getText().toString()
        //Con esto funciona y desaparece el cero(si es la unica variable nullable, si tambien adapto signo, operación y resultado me sale null). Ver cómo adaptar el if de escribir número
        //var texto:String?=null
        //texto.plus(binding.tvNumero.getText().toString())
        var textoSegundoPlano=""

        var signoNuevo=""

        fun escribirNumero(digito:String){
            if (texto.equals("0")){
                binding.tvNumero.text=""
            }
            texto+=digito
            binding.tvNumero.text=texto
        }

        fun elegirOperacion(operacion:String){
            signo=operacion
            //Con signo y operación nulables funcionan las cuentas. Sin eso se queda enganchado en el +
            texto=operacion
            binding.tvNumero.text=texto
        }

        //Incluso haciendo esta función a parte NO ME FUNCIONA!!! Y SI LA USO TODO SERAN SUMAS
        fun textoOperacion(simbolo:String){
            texto+=simbolo
            binding.tvNumero.text=texto
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

        fun pasarTextoSegundoPlano(){
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
            signo=""
            binding.tvNumero.text=""
            binding.tvOperacion.text=""
            texto=binding.tvNumero.text.toString()
            textoSegundoPlano=binding.tvOperacion.text.toString()

        }


        binding.b0.setOnClickListener{ escribirNumero("0") }
        binding.b1.setOnClickListener{ escribirNumero("1") }
        binding.b2.setOnClickListener{ escribirNumero("2") }
        binding.b3.setOnClickListener{ escribirNumero("3") }
        binding.b4.setOnClickListener{ escribirNumero("4") }
        binding.b5.setOnClickListener{ escribirNumero("5") }
        binding.b6.setOnClickListener{ escribirNumero("6") }
        binding.b7.setOnClickListener{ escribirNumero("7") }
        binding.b8.setOnClickListener{ escribirNumero("8") }
        binding.b9.setOnClickListener{ escribirNumero("9") }

        binding.bmasmenos.setOnClickListener{}

        binding.bcoma.setOnClickListener{ escribirNumero(".") }

        binding.bigual.setOnClickListener{
            pasarTextoSegundoPlano()
            guardarNumero()
            igual()
        }


        binding.bmas.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano()
            borrarTexto()
            elegirOperacion("+")
            pasarTextoSegundoPlano()
            borrarTexto()
            //textoOperacion("+")
        }

        binding.bmenos.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano()
            borrarTexto()
            elegirOperacion("-")
            pasarTextoSegundoPlano()
            borrarTexto()
           //textoOperacion("-")
        }

        binding.bmult.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano()
            borrarTexto()
            elegirOperacion("x")
            pasarTextoSegundoPlano()
            borrarTexto()
            //textoOperacion("x")
        }

        binding.bdiv.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano()
            borrarTexto()
            elegirOperacion("/")
            pasarTextoSegundoPlano()
            borrarTexto()
            //textoOperacion("/")
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