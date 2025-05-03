object ReceitaFederal {
  fun calcularImposto(salario: Double): Double {
  	val aliquota = when {
      salario in 0.00..1100.00 -> 0.05
      salario in 1100.01..2500.00 -> 0.10
      salario > 2500.00 -> 0.15
      else -> 0.00
    }
  	return aliquota * salario
  }
}

fun main() {
  val valorSalario = readLine()!!.toDouble();
  val valorBeneficios = readLine()!!.toDouble();
  
  val valorImposto = ReceitaFederal.calcularImposto(valorSalario);
  val saida = valorSalario - valorImposto + valorBeneficios;
  
  println("%.2f".format(saida));
}