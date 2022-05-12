package com.letscode.springmysql;

import com.letscode.springmysql.sql.SQLHandler;

import java.sql.ResultSet;
import java.util.Scanner;

public class GUIHandler
{
    static boolean isRunning = true;
    static Scanner scanner = new Scanner(System.in);

    public static void showGUI()
    {
        while (isRunning)
        {
            showMenu();
        }
    }

    private static void showMenu()
    {
        System.out.println("Opções:");
        System.out.println("1 - Empresa");
        System.out.println("2 - Produto");
        System.out.println("3 - Vendas");
        System.out.println("4 - Visualizar vendas");
        System.out.println("5 - Sair");
        int option = scanner.nextInt();

        switch (option)
        {
            case 1:
                showCompanyMenu();
                break;
            case 2:
                showProductMenu();
                break;
            case 3:
                showSaleMenu();
                break;
            case 4:
                showSaleList();
                break;
            case 5:
                isRunning = false;
                break;
        }
    }

    private static void showSaleList()
    {
        System.out.println("Opções:");
        System.out.println("1 - Total vendas por cliente");
        System.out.println("2 - Total vendas Recorrente");
        System.out.println("3 - Total vendas por UF");
        int option = scanner.nextInt();
        ResultSet resultSet;
        switch (option)
        {
            case 1:
                System.out.println("#############################################################################################");
                resultSet = SQLHandler.executeSQL(SQLHandler.VENDAS_CLIENTES);
                try
                {
                    while (resultSet.next())
                    {
                        System.out.println(resultSet.getString("empresa") + " = " + resultSet.getString("TotalDeVendas"));
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("#############################################################################################");
                break;
            case 2:
                System.out.println("#############################################################################################");
                resultSet = SQLHandler.executeSQL(SQLHandler.VENDAS_RECORRENTE);
                try
                {
                    while (resultSet.next())
                    {
                        System.out.println(resultSet.getString("empresa") + " = " + resultSet.getString("TotalDeVendasRecorrente"));
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("#############################################################################################");
                break;
            case 3:
                System.out.println("#############################################################################################");
                resultSet = SQLHandler.executeSQL(SQLHandler.VENDAS_POR_UF);
                try
                {
                    while (resultSet.next())
                    {
                        System.out.println(resultSet.getString("uf") + " = " + resultSet.getString("TotalDeVendas"));
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("#############################################################################################");
                break;
        }
    }

    //Parte do Igor


}
