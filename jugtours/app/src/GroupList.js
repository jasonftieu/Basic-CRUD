import React, {Component} from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavBar from './AppNavBar';
import { Link } from 'react-router-dom';

class GroupList extends Component {

    constructor(props) {
        super(props);
        this.state = {groups: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/groups')
            .then(response => response.json())
            .then(data => this.setState({groups: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/api/group/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedGroups = [...this.state.groups].filter(i => i.id !== id);
            this.setState({groups: updatedGroups});
        })
    }

    render() {
        const {groups, isLoading} = this.state;

        if (!isLoading) {
            return <p>Loading...</p>;
        }

        const groupList = groups.map(group => {
            const address = `${group.address || ''} ${group.city || ''} ${group.stateOrProvince || ''}`;
            return <tr key={group.id}>

            </tr>
        })
    }
}