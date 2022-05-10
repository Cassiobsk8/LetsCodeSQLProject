package com.letscode.springmysql.model.db;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USUARIO")
public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String primeiroNome;
    @Column
    private String sobrenome;
    @Column
    private Date dataCadastro;

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId()
    {
        return id;
    }

    public void setPrimeiroNome(String primeiroNome)
    {
        this.primeiroNome = primeiroNome;
    }

    public String getPrimeiroNome()
    {
        return primeiroNome;
    }

    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome()
    {
        return sobrenome;
    }

    public void setDataCadastro(Date dataCadastro)
    {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataCadastro()
    {
        return dataCadastro;
    }

}
