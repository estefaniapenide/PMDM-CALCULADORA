package com.example.calculadora_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

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

        fun pasarTextoSegundoPlano(){
            binding.tvOperacion.setText("${binding.tvOperacion.text}${binding.tvNumero.text}")
        }

        fun borrarTexto(){
            binding.tvNumero.setText("")
        }

        fun escribirNumero(digito:String){
            //Añadí esto para que cuando se escriba un número tras un signo, el signo pase a segundo plano y se empiece un número nuevo en la principal
            //Pero no funciona!!
            /*if(binding.tvNumero.text.equals("[+-x/]{1}".toRegex())){
                pasarTextoSegundoPlano()
                borrarTexto()
            }*/
            if (binding.tvNumero.getText().toString().equals("0")){
                binding.tvNumero.setText("")
            }
            binding.tvNumero.setText("${binding.tvNumero.getText()}$digito")
        }

        fun elegirOperacion(operacion:String){
            //Falla en la multiplicación y en la división creo que porque coje como signo el signo mas el número que viene despues?? o algo asi
            //Mirar bien!!
            signo.replace("[+-x/]{1}".toRegex(),operacion)
            binding.tvNumero.setText(operacion)
        }


        fun igual(){
            reasignacion(operacion(resultado,numero,signo))
            binding.tvNumero.setText("= $resultado")
        }


        fun guardarNumero(){
            if(resultado==0.0){
                resultado=binding.tvNumero.text.toString().toDouble()
            }else {
                numero = binding.tvNumero.text.toString().toDouble()
            }
        }



        fun reinicio(){
            resultado=0.0
            numero=0.0
            //signo=""
            binding.tvNumero.setText("")
            binding.tvOperacion.setText("")
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
            //Creía que esto lo arrgalaba pero no. Al meterle esto TODO SON SUMAS
           /* pasarTextoSegundoPlano()
            borrarTexto()*/
        }

        binding.bmenos.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano()
            borrarTexto()
            elegirOperacion("-")
            //Creía que esto lo arrgalaba pero no
            /*pasarTextoSegundoPlano()
            borrarTexto()*/
        }

        binding.bmult.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano()
            borrarTexto()
            elegirOperacion("x")
            //Creía que esto lo arrgalaba pero no
           /*pasarTextoSegundoPlano()
            borrarTexto()*/
        }

        binding.bdiv.setOnClickListener{
            guardarNumero()
            pasarTextoSegundoPlano()
            borrarTexto()
            elegirOperacion("/")
            //Creía que esto lo arrgalaba pero no
            /*pasarTextoSegundoPlano()
            borrarTexto()+/
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