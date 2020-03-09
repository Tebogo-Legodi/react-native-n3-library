# react-native-n3-library: Getting started

## Update your package.json

```json
"dependencies": {
    "react-native-n3-library": "git+https://gitlab.blts.co.za/tebogol/nexgon3.git" 
}
```


### Install Packages

`$ npm install`

## Usage
```javascript
import N3Library from 'react-native-n3-library';

// Getting the serial No
getDeviceSerialNo(){

    N3Library.getSerialNo((serialNo)=>{
        alert(serialNo);
    },(err)=>{
        alert(err); 
    });
}

   

```
