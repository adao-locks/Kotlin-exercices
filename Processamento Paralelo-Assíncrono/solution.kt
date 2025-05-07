fun main() {
    val urls = mutableListOf<String>()

    while (true) {
        val input = readLine() ?: break
        if (input.isBlank()) break
        urls.add(input)
    }

    println("Iniciando downloads...")

    // Cria uma lista de Pair (indice, tamanho)
    val results = mutableListOf<Pair<Int, Int>>()

    // Cria e inicia uma thread para cada URL
    val threads = urls.mapIndexed { index, url ->
        Thread {
            // Simula o download com 1 segundo de espera
            Thread.sleep(1000)
            val length = openLink(url)
            synchronized(results) {
                results.add(Pair(index, length))
            }
        }.also { it.start() } // Inicia a thread imediatamente
    }

    // Aguarda todas as threads terminarem
    threads.forEach { it.join() }

    // Ordena os resultados por índice para imprimir na ordem correta
    results.sortedBy { it.first }.forEachIndexed { idx, result ->
        println("Arq${idx + 1}: ${result.second}")
    }
    println("Tempo total: ${urls.size}")
}

// Simula a abertura de uma URL, retornando seu tamanho.
fun openLink(url: String): Int {
    return url.length
}
