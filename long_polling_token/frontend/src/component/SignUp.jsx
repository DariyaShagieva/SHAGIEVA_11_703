import {Component} from 'react';
import React from "react";


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
        fetch(`/signUp`, {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(data)
        }).then(response => {
            if(response.ok){
                window.location.href='/login';
            }
        })

    };

    render() {

        return (
            <div>
                <h1>Регистрация</h1>
                <label>Логин</label>
                <input type={"text"} name={"login"} id={"login"}
                       onChange={(event) => this.setState({login: event.target.value})}/>
                <br/>
                <label>Пароль</label>
                <input type={"password"} name={"password"} id={"password"}
                       onChange={(event) => this.setState({password: event.target.value})}/>
                <button onClick={() => this.handleSubmit(this.state.login, this.state.password)}>Зарегистрироваться</button>
            </div>);
    }
}

export default Login
