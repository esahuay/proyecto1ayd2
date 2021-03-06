/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Parsers.lexico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import compi1_proyecto1.*;
import static compi1_proyecto1.Menu.erroresText;
import static compi1_proyecto1.Menu.paneText;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

/**
 *
 * @author Mac
 */
public class JUnit_Tests {

    String resultadoEsperado;
    String path;

    public JUnit_Tests() {
        path = "C:\\Users\\Mac\\Documents\\NetBeansProjects\\Compi1Proyecto1\\";
        resultadoEsperado = "<configuration><background>{x-nombre=grass;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/fondo1.jpg\";},{x-nombre=digital;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/fondo2.jpg\";},{x-nombre=stones;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/fondo3.jpg\";},{x-nombre=grass2;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/fondo4.jpg\";}</background><figure>{x-nombre=MegaMan;x-vida=100;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/heroe1.png\";x-tipo=x-heroe;x-descripcion=\"Defensor de la red y del mundo virtual.\";},{x-nombre=ProtoMan;x-vida=100;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/heroe2.png\";x-tipo=x-heroe;x-descripcion=\"Heroe solitario y muy habil con un gran sentido de la justicia.\";},{x-nombre=Bass;x-vida=150;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/heroe3.png\";x-tipo=x-heroe;x-descripcion=\"Inusual y misterioso heroe que utiliza sus poderes oscuros para la justicia.\";},{x-nombre=iceman;x-vida=40;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo1.png\";x-tipo=x-villano;x-destruir=50;x-descripcion=\"Enemigo de hielo.\";},{x-nombre=mazeman;x-vida=40;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo2.png\";x-tipo=x-villano;x-destruir=50;x-descripcion=\"Enemigo con una coraza indestructible.\";},{x-nombre=driller;x-vida=10;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo3.png\";x-tipo=x-villano;x-destruir=20;x-descripcion=\"Enemigo que perfora todo lo que ve.\";},{x-nombre=rocket;x-vida=10;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo4.png\";x-tipo=x-villano;x-destruir=10;x-descripcion=\"Enemigo que explota cuando fija un objetivo.\";},{x-nombre=scopeg;x-vida=20;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo5.png\";x-tipo=x-villano;x-destruir=30;x-descripcion=\"Enemigo con casco color verde que se defiende muy bien.\";},{x-nombre=scope;x-vida=10;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo6.png\";x-tipo=x-villano;x-destruir=10;x-descripcion=\"Enemigo con casco color amarillo que se defiende bien.\";},{x-nombre=ScissorMan;x-vida=30;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo8.png\";x-tipo=x-villano;x-destruir=15;x-descripcion=\"Enemigo con tijeras en la cabeza un poco tonto.\";},{x-nombre=BullMan;x-vida=40;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo7.png\";x-tipo=x-villano;x-destruir=50;x-descripcion=\"Enemigo muy poderoso que ataca con cuernos de toro.\";},{x-nombre=CannonMan;x-vida=40;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo9.png\";x-tipo=x-villano;x-destruir=50;x-descripcion=\"Enemigo muy poderoso que utiliza disparos de energia.\";},{x-nombre=DarkSamus;x-vida=70;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/enemigo10.png\";x-tipo=x-villano;x-destruir=65;x-descripcion=\"Ser malvado proveniente de un universo diferente extremadamente poderoso.\";}</figure><design>{x-nombre=bomba1;x-destruir=20;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/bomba1.png\";x-tipo=x-bomba;},{x-nombre=bomba2;x-destruir=30;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/bomba2.png\";x-tipo=x-bomba;},{x-nombre=arma1;x-destruir=30;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/arma1.png\";x-tipo=x-arma;},{x-nombre=arma2;x-destruir=70;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/arma2.png\";x-tipo=x-arma;},{x-nombre=arma3;x-destruir=40;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/arma3.png\";x-tipo=x-arma;},{x-nombre=arma4;x-destruir=30;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/arma4.png\";x-tipo=x-arma;},{x-nombre=arma5;x-destruir=30;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/arma5.png\";x-tipo=x-arma;},{x-nombre=energyT;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/bonus1.png\";x-tipo=x-bonus;x-creditos=65;},{x-nombre=energyB;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/bonus2.png\";x-tipo=x-bonus;x-creditos=50;},{x-nombre=life;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/bonus3.png\";x-tipo=x-bonus;x-creditos=100;},{x-nombre=bloque1;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/bloque1.png\";x-tipo=x-bloque;},{x-nombre=bloque2;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/bloque2.png\";x-tipo=x-bloque;},{x-nombre=bloque3;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/bloque3.png\";x-tipo=x-bloque;},{x-nombre=salida1;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/meta1.png\";x-tipo=x-meta;},{x-nombre=salida2;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/meta2.png\";x-tipo=x-meta;},{x-nombre=salida3;x-imagen=\"C:/Users/Mac/Documents/NetBeansProjects/Compi1Proyecto1/src/Imagenes/meta3.png\";x-tipo=x-meta;}</design></configuration>";
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLeerArchivo() {
        String resultado = CsvClass.leer("TestArch1.xconf");
        assertTrue("Error leyendo el archivo", resultado.trim().equalsIgnoreCase(resultadoEsperado));
    }

    @Test
    public void testEnemigos() {
        Compi1_Proyecto1.TodosEnemigos.clear();
        try {
            lexico lexic = new Parsers.lexico(new StringReader(resultadoEsperado));
            for (int i = 0; i < 1000; i++) {
                try {
                    Symbol a = lexic.next_token();
                } catch (Exception e) {
                    i = 1001;
                }
            }
            new Parsers.sintactico(new Parsers.lexico(new StringReader(resultadoEsperado))).parse();

        } catch (Exception ex) {
            Logger.getLogger(Compi1_Proyecto1.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue("Enemigos cargados incorrectamente", Compi1_Proyecto1.TodosEnemigos.size() == 8);
    }

    @Test
    public void testHeroes() {
        Compi1_Proyecto1.TodosHeroes.clear();
        try {
            lexico lexic = new Parsers.lexico(new StringReader(resultadoEsperado));
            for (int i = 0; i < 1000; i++) {
                try {
                    Symbol a = lexic.next_token();
                } catch (Exception e) {
                    i = 1001;
                }
            }
            new Parsers.sintactico(new Parsers.lexico(new StringReader(resultadoEsperado))).parse();

        } catch (Exception ex) {
            Logger.getLogger(Compi1_Proyecto1.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue("Heroes cargados incorrectamente", Compi1_Proyecto1.TodosHeroes.size() == 2);
    }

    @Test
    public void testBackgrounds() {
        Compi1_Proyecto1.TodosBackrounds.clear();
        try {
            lexico lexic = new Parsers.lexico(new StringReader(resultadoEsperado));
            for (int i = 0; i < 1000; i++) {
                try {
                    Symbol a = lexic.next_token();
                } catch (Exception e) {
                    i = 1001;
                }
            }
            new Parsers.sintactico(new Parsers.lexico(new StringReader(resultadoEsperado))).parse();

        } catch (Exception ex) {
            Logger.getLogger(Compi1_Proyecto1.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue("Backgrounds cargados incorrectamente", Compi1_Proyecto1.TodosBackrounds.size() == 4);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
