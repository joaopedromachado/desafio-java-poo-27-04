package br.com.agi.jucaflix;

import java.util.Scanner;

public class MenuInteractionService implements UserNavigationMenu {

    MovieRepository repository = new MovieRepository();
    Scanner scanner = new Scanner(System.in);
    int opMenu, year, indexRemoveMovie,  indexMovie;
    String title, director, genreStr;
    double rating;

    public void runApplication()  {
        do {
            printUserMenu();
            switch (opMenu){
                case 1:
                    addInteractionMenu();
                    break;
                case 2:
                    removeInteractionMenu();
                    break;
                case 3:
                    userMovieSearcher();
                    break;
                case 4:
                    changeUserMovieRating();
                    break;
                case 5:
                    userRecommendationMovie();
                    break;
                case 6:
                    repository.getAllMoviesInRepository();
                    break;
            }
        }while(opMenu != 0);

        System.out.println("\n\nOBRIGADO POR USAR O JUCAFLIX! ^_^");
    }

    public void checkIfGenreExists(){
        Genre genre = null;
        while(genre == null) {
            System.out.print("Digite o gênero do filme (ACTION, COMEDY, DRAMA, HORROR, ROMANCE): ");
            genreStr = scanner.nextLine().toUpperCase();
            try {
                genre = Genre.valueOf(genreStr);
            }catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void userRecommendationMovie() {
        System.out.print("Digite o gênero do filme (ACTION, COMEDY, DRAMA, HORROR, ROMANCE): ");
        genreStr = scanner.nextLine().toUpperCase();
        genreStr = scanner.nextLine().toUpperCase();
        System.out.print("Informe a classificação mínima: ");
        rating = scanner.nextDouble();
        new MovieRecommendationService(Genre.valueOf(genreStr), rating).recommendMovies(repository);
        System.out.println(new MovieRecommendationService(Genre.valueOf(genreStr), rating).recommendMovies(repository));
    }

    @Override
    public void changeUserMovieRating(){
        repository.getAllMoviesInRepository();

        System.out.print("Selecione o código do filme: ");
        indexMovie = scanner.nextInt();

        System.out.print("Alterar classificação: ");
        rating = scanner.nextDouble();

        repository.changeMovieRatingByIndex(indexMovie, rating);
    }

    @Override
    public void userMovieSearcher(){
        int opUser;
        do {
            System.out.print("\nOpções de busca por filmes\n1 - Buscar por gênero\n2 - Buscar por classificação\n0 - Voltar ao menu principal\nDigite: ");
            opUser = scanner.nextInt();
            switch (opUser){
                case 1:
                    System.out.print("Procure um filme pelo gênero: ");
                    genreStr = scanner.nextLine().toUpperCase();
                    genreStr = scanner.nextLine().toUpperCase();
                    try{
                        System.out.println(repository.searchMovies(movie -> movie.getGenre() == Genre.valueOf(genreStr)));
                    }catch(IllegalArgumentException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Procure um filme pela classificação: ");
                    rating = scanner.nextDouble();
                    try{
                        System.out.println(repository.searchMovies(movie -> movie.getRating() > rating));
                    }catch(IllegalArgumentException e){
                        e.printStackTrace();
                    }
                    break;
            }
        }while(opUser != 0);
    }

    @Override
    public void addInteractionMenu()  {
        System.out.print("Título do filme: ");
        scanner.nextLine();
        title = scanner.nextLine();

        System.out.print("Ano de lançamento: ");
        year = scanner.nextInt();
        scanner.nextLine();

        checkIfGenreExists();

        System.out.print("Diretor do filme: ");
        director = scanner.nextLine();

        System.out.print("Classificação do filme: ");
        rating = scanner.nextDouble();

        repository.addMovie(new Movie(title, year, Genre.valueOf(genreStr), director, rating));
        System.out.println("\nFilme adicionado com sucesso.\n");
    }


    @Override
    public void removeInteractionMenu() {
        repository.getAllMoviesInRepository();
        do {
            System.out.print("Baseado no código do filme, remova o N°: ");
            indexRemoveMovie = scanner.nextInt();

            if (!repository.isIndexListMovieValid(indexRemoveMovie)) {
                System.out.println("\nCódigo inválido, tente novamente.\n");
            }
        } while (!repository.isIndexListMovieValid(indexRemoveMovie));

        repository.removeMovie(indexRemoveMovie);
        System.out.println("\nFilme removido com sucesso.\n");
    }

    @Override
    public void printUserMenu() {
        System.out.print(
                "-------------------------------------------- \n" +
                        "|   BEM-VINDO(A) AO GERENCIADOR DE FILMES  |\n" +
                        "|                                          |\n" +
                        "|  1 - Adicionar filmes                    |\n" +
                        "|  2 - Remove filmes                       |\n" +
                        "|  3 - Pesquisar filmes                    |\n" +
                        "|  4 - Classificar filmes                  |\n" +
                        "|  5 - Recomendar filmes                   |\n" +
                        "|  6 - Listar todos os filmes              |\n" +
                        "|  0 - Sair                                |\n" +
                        "--------------------------------------------\n\n" +
                        "Digite uma opção: ");

        opMenu = scanner.nextInt();
    }
}
