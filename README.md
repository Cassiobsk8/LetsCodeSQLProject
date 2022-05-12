# LetsCodeSQLProject
Projeto de miniCRM desenvolvido no curso de JAVA e MySQL ministrado por LetsCode.

Diagrama:






1. Definição lógica (Aplicação):
Opções: 
[a] Empresa
[a1] Cadastrar empresa
[a2] Editar empresa

[b] Produto
[b1] Cadastrar produto
[b2] Editar produto

[c] Vendas 
[c1] Cadastrar Venda
[c2] Cancelar Venda Recorrente

[d] Visualizar negócios
[d1] Total vendas por clientes
[d2] Total vendas Recorrentes
[d3] Total vendas por UF



table #1 - Info empresa
create table infoEmpresa(
id
Empresa
CNPJ
Cidade
UF
);



table #2 - Info produtos 
create table infoProdutos(
id
produto
vertical
Valor base
Descricao item
);


table #3 - Info produtos &  Info empresa
create table vendas (
id
id empresa
id produto
data compra
valor negociado
tipo compra
);
![image](https://user-images.githubusercontent.com/54718961/167992691-c221290a-a572-4af9-8873-28a3b25cf5f0.png)
