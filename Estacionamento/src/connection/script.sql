/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Thyane
 * Created: 6 de out. de 2022
 */

CREATE DATABASE IF NOT EXISTS estacionamento;
USE estacionamento;

CREATE TABLE vaga (
    idVaga int NOT NULL AUTO_INCREMENT,
    numero int NOT NULL,
    rua varchar(100) NOT NULL,
    obliqua boolean NOT NULL,
    PRIMARY KEY (idVAga));

CREATE TABLE motorista (
    idMotorista int NOT NULL AUTO_INCREMENT,
    nomemotorista varchar (100) NOT NULL,
    NomeCompleto varchar (100) NOT NULL,
    genero varchar (100) NOT NULL,
    rg int NOT NULL,
    cpf int NOT NULL,
    celular int NOT NULL,
    email varchar (100) NOT NULL,
    senha varchar (100) NOT NULL,
    PRIMARY KEY (idMotorista));
