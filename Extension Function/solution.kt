fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""
    
    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()
    
    println("Slug gerado para o livro:")
    
    println("${slugTitulo}_${slugAutor}")
}

fun String.generateSlug(): String {
    return this
        .lowercase()
        .replace(Regex("[^a-z0-9\\s]"), "")
        .trim()
        .replace("\\s+".toRegex(), "-")
}