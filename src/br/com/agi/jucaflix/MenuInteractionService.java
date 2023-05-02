package br.com.agi.jucaflix;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class MenuInteractionService implements UserNavigationMenu, AddUserMovie, RemoveUserMovies {

    MovieRepository repository = new MovieRepository();
    Scanner scanner = new Scanner(System.in);
    int opMenu, year, indexRemoveMovie;
    String title, director, genreStr;
    double rating;

    public void runApplication()  {
        do {
            printUserMenu();
            if (opMenu == 1){
                addInteractionMenu();
            } else if (opMenu == 2) {
                removeInteractionMenu();
            } else if (opMenu == 3){
                userMovieSearcher();
            } else if (opMenu == 4) {
                System.out.println("Classificar filmes.");
            } else if (opMenu == 5) {
                System.out.println("Recomendar filmes.");
            }
        }while(opMenu != 0);

        repository.getAllMovies();
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

    public void userMovieSearcher(){
        System.out.println("Digite ");
    }

    @Override
    public void addInteractionMenu()  {
        System.out.print("Título do filme: ");
        title = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ano de lançamento do filme: ");
        year = scanner.nextInt();
        scanner.nextLine();
        checkIfGenreExists();
        System.out.print("Diretor do filme: ");
        director = scanner.nextLine();
        System.out.print("Classificação do filme: ");
        rating = scanner.nextDouble();

        repository.addMovie(new Movie(title, year, Genre.valueOf(genreStr), director, rating));
        System.out.println("\nFilme adicionado com sucesso.");
    }


    @Override
    public void removeInteractionMenu() {
        System.out.print("Qual filme você deseja remover? ");
        indexRemoveMovie = scanner.nextInt();
        repository.removeMovie(indexRemoveMovie);
        System.out.println("Filme removido com sucesso.");
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
                        "|  0 - Sair                                |\n" +
                        "--------------------------------------------\n\n" +
                        "Digite uma opção: ");

        opMenu = scanner.nextInt();
    }
}
