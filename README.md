Desafio POO (27/04)

Você deve implementar um sistema de gerenciamento de filmes em Java. O sistema deve permitir que os usuários adicionem, removam, pesquisem e classifiquem filmes. Além disso, o sistema deve ser capaz de recomendar filmes com base nas preferências do usuário.


Requisitos:

Crie uma classe concreta "Movie" com os seguintes atributos:

Title (título) - String
            
Year (ano) - int
            
Genre (gênero) - enum com valores para ação, comédia, drama, terror e romance.
            
Director (diretor) - String
            
Rating (classificação) - double
            
A classe também deve ter os seguintes métodos:
            
addRating(double rating) - para adicionar uma classificação ao filme.
            
toString() - para retornar uma representação em String do objeto filme.

Crie uma interface "MovieFilter" com o seguinte método:

boolean filter(Movie movie) - para filtrar os filmes com base em um determinado critério. Este método deve retornar true se o filme atender ao critério de filtragem e false caso contrário.
      
Crie uma classe concreta "MovieRepository" com o seguinte atributo:
      
movies (filmes) - ArrayList de objetos do tipo Movie.
            
A classe deve ter os seguintes métodos:
            
addMovie(Movie movie) - para adicionar um filme ao repositório.
            
removeMovie(Movie movie) - para remover um filme do repositório.
            
searchMovies(MovieFilter filter) - para buscar filmes com base em um critério de filtragem. Este método deve retornar uma lista de objetos do tipo Movie que atendem ao critério de filtragem.
      
Crie uma classe "MovieRecommendationService" que implementa a interface "MovieFilter".
Esta classe deve ter os seguintes atributos:

userPreferences (preferências do usuário) - enum com valores para ação, comédia, drama, terror e romance.
            
ratingThreshold (limiar de classificação) - double
            
A classe deve ter os seguintes métodos:
            
filter(Movie movie) - para filtrar os filmes com base nas preferências do usuário e no limiar de classificação. Este método deve retornar true se o filme atender aos critérios de filtragem e false caso contrário.
            
recommendMovies(MovieRepository repository) - para recomendar filmes com base nas preferências do usuário e no limiar de classificação. Este método deve retornar uma lista de objetos do tipo Movie que atendem aos critérios de filtragem.
            
      
Na classe principal do seu programa, crie um menu para que o usuário possa escolher entre adicionar, remover, pesquisar e classificar filmes. Além disso, inclua uma opção para recomendar filmes com base nas preferências do usuário.