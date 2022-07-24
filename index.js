import { NativeModules } from 'react-native';

const { N3Library } = NativeModules;

export function print(jsonData){
    return N3Printer.print(jsonData);
};
  
export function getSerialNumber(){
    return  N3Printer.getSerialNumber();
}

export default N3Library;

