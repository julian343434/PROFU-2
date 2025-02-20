/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factories;

import InteractorsUseCases.CrearPersonaUseCase;
import InteractorsUseCases.ListarPersonasUseCase;

/**
 *
 * @author PYKE
 */
public class UseCaseFactory {

    public static CrearPersonaUseCase createCrearPersonaUseCase() {
        return new CrearPersonaUseCase();
    }

    public static ListarPersonasUseCase createListarPersonasUseCase() {
        return new ListarPersonasUseCase();
    }
}
