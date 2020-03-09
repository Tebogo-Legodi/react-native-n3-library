# react-native-n3-library: Getting started

## Update your package.json

"dependencies": {
    "react": "16.9.0",
    "react-native": "0.61.5",
    `$"react-native-n3-library": "git+https://gitlab.blts.co.za/tebogol/nexgon3.git"`
}


### Install Packages

`$ npm install`

## Usage
```javascript
import N3Library from 'react-native-n3-library';

// Getting the serial No: What to do with the module?
getDeviceSerialNo(){

    N3Library.getSerialNo((serialNo)=>{
        alert(serialNo);
    },(err)=>{
        alert(err); 
    });
}

   

```
