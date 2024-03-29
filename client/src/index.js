import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import './fonts/flame/FlameRegular.otf'
import './fonts/rotonda/RotondaC.otf'
import './fonts/robo/19189.ttf'
import {BrowserRouter} from "react-router-dom";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
        <App />
    </BrowserRouter>

);

