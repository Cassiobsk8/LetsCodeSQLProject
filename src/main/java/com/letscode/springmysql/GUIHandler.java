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
    
    private static void showSaleMenu()
    {
        System.out.println("Opções:");
        System.out.println("1 - Cadastrar venda");
        System.out.println("2 - Cancelar Venda Recorrente");
        int option = scanner.nextInt();
        switch (option)
        {
            case 1:
                System.out.println("Digite o id da empresa:");
                int companyId = scanner.nextInt();
                System.out.println("Digite o id do produto:");
                int productId = scanner.nextInt();
                System.out.println("Digite o valor da compra:");
                float value = scanner.nextFloat();
                System.out.println("Digite o tipo da compra (SERVIÇOS RECORRENTES, LINX PAY, ETC...):");
                String type = scanner.next();

                SQLHandler.executeSQL("INSERT INTO vendas (idEmpresa, idProduto, dataCompra, valorNegociado, tipoCompra) VALUES (" + companyId + ", " + productId + ", " + LocalDate.now().toString() + ", " + value + ", '" + type + "')");
                break;
            case 2:
                System.out.println("Digite o id da compra:");
                int orderId = scanner.nextInt();
                SQLHandler.executeSQL("DELETE FROM vendas WHERE id = " + orderId);
                break;
        }
    }

    private static void showProductMenu()
    {
        System.out.println("Opções:");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Editar nome do produto");
        int option = scanner.nextInt();
        switch (option)
        {
            case 1:
                System.out.println("Digite o nome do produto:");
                String name = scanner.next();
                System.out.println("Digite a vertical do produto:");
                String vertical = scanner.next();
                System.out.println("Digite o Valor Base do produto:");
                float value = scanner.nextFloat();
                System.out.println("Digite a Descrição do produto:");
                String description = scanner.next();
                SQLHandler.executeSQL("INSERT INTO infoproduto (produto,vertical,valorBase,DescricaoItem) VALUES ('" + name + "', '" + vertical + "', " + value + ", '" + description + "')");
                break;
            case 2:
                System.out.println("Digite o id do produto:");
                int id = scanner.nextInt();
                System.out.println("Digite o nome do produto:");
                name = scanner.next();
                SQLHandler.executeSQL("UPDATE infoproduto SET produto = '" + name + "' WHERE id = " + id);
                break;
        }
    }

    private static void showCompanyMenu()
    {
        System.out.println("Opções:");
        System.out.println("1 - Cadastrar empresa");
        System.out.println("2 - Editar cnpj da empresa");
        int option = scanner.nextInt();
        switch (option)
        {
            case 1:
                System.out.println("Digite o nome da empresa:");
                String name = scanner.next();
                System.out.println("Digite o CNPJ da empresa:");
                String cnpj = scanner.next();
                System.out.println("Digite a cidade da empresa:");
                String city = scanner.next();
                System.out.println("Digite o estado da empresa:");
                String state = scanner.next();
                SQLHandler.executeSQL("INSERT INTO infoEmpresa(empresa,cnpj,cidade,UF) VALUES ('" + name + "', '" + cnpj + "', '" + city + "', '" + state + "')");
                break;
            case 2:
                System.out.println("Digite o id da empresa:");
                int id = scanner.nextInt();
                System.out.println("Digite o CNPJ da empresa:");
                cnpj = scanner.next();
                SQLHandler.executeSQL("UPDATE infoEmpresa SET cnpj = '" + cnpj + "' WHERE id = " + id);
                break;
        }
    }


}
