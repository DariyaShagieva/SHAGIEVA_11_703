import {Component} from 'react';
import React from "react";
import {Link} from "react-router-dom";


class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            login: '',
            password: '',
        }
    }


    handleSubmit = (login, password) => {
        var data = {
            login: login,
            password: password
        };
        fetch(`/login`, {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(data)
        }).then((response) => response.json())
            .then((responseJson) => {
                if (responseJson.value !== undefined) {
                    localStorage.setItem("value", responseJson.value);
                    window.location.href='/chat/' + this.state.login;
                }
                else document.getElementById("errorUser").innerText = "Неправильный логин или пароль"
            })
            .catch((error) => {
                console.log(error);
            })
    };

    render() {

        return (
            <div>
                <p id={"errorUser"}/>
                <h1>Вход</h1>
                <label>Логин</label>
                <input type={"text"} name={"login"} id={"login"}
                       onChange={(event) => this.setState({login: event.target.value})}/>
                <br/>
                <label>Пароль</label>
                <input type={"password"} name={"password"} id={"password"}
                       onChange={(event) => this.setState({password: event.target.value})}/>
                <button onClick={() => this.handleSubmit(this.state.login, this.state.password)}>Войти</button>
                <Link to={'/signUp'} >Регистрация</Link>
            </div>);
    }
}

export default Login
