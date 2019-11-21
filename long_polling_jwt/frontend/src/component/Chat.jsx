import React, {Component} from 'react';



class Chat extends Component {
    constructor(props) {
        super(props);
        this.state = {
            message: '',
            messages: []
        }
    }

    componentDidMount() {
        fetch('/chat/' + this.props.match.params.user, {
            method: 'get',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8",
                "AUTH": localStorage.getItem("value")
            },
        }).then((response) => response.json())

            .then((responseJson) => {
                this.setState({messages: responseJson});
                // console.log(this.state.messages);
                this.hiMessage(this.props.match.params.user)
            })
            .catch((error) => {
                window.location.href='/login';
            })
    };

    hiMessage = (user) => {
        var body = {
            authorLogin: user,
            text: 'Пользователь присоединился к чату',
            hiMessage: true
        };
        fetch(`/messages`, {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8",
                "AUTH": localStorage.getItem("value")
            },
            body: JSON.stringify(body)
        }).then(this.receiveMessage);
    };

    sendMessage = (message) => {
        var data = {
            authorLogin: this.props.match.params.user,
            text: message,
            hiMessage: false
        };
        fetch('/messages', {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8",
                "AUTH": localStorage.getItem("value")
            },
            body: JSON.stringify(data)
        });
        console.log(data)
    };
    receiveMessage = () => {
        fetch(`/messages`, {
            method: 'get',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8",
                "AUTH": localStorage.getItem("value")
            },
        }).then(response => {
                return response.json();
            })
            .then(responseJson => {
                //
                let arr = this.state.messages;
                let newMessages = arr.concat(responseJson);
                this.setState({messages: newMessages});

            })
            .catch(error => {
                console.log(error);
            }).finally(()=>{this.receiveMessage();})
    };

    renderMessage() {
        console.log(this.state.messages);
        return this.state.messages.map(message =>
            (
                <li>{message.authorLogin}:{message.text}</li>
            )
        )
    }
    render() {
        return (
            <div>
                <h1>Chat</h1>
                <h2>Добро пожаловать, {this.props.match.params.user} </h2>
                <div>
                    <ul>
                        {this.renderMessage()}
                    </ul>
                </div>
                <input id={"message"} placeholder={"Ваше сообщение"}
                       onChange={(event) => this.setState({message: event.target.value})}/>
                <button onClick={() => this.sendMessage(this.state.message)}>Отправить</button>
            </div>

        )
    }

}

export default Chat