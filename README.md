# react-native-n3-library: Getting started

Printing library for the N3 devices and retrieving the serial number

## Installation

```sh
npm install git+https://gitlab.blts.co.za/tebogo/react-native-n3-printer.git
```

## Usage (Printing)
There are two types of Print Data you can pass: <br>

##### 1) Image

```js
{
  type: "image", // image |text
  //If Type is image, the data that should be based is base64 encoded file
  data: "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",
  alignment: "center" // center |left |right
}
// NB: The payload for the image type consist of the following attributes: type, data & alignment
```
##### 2) Text
```js
{
  type: "text",
  data: "Tebogo Legodi",
  alignment: "center", // center |left |right
  size: "normal", // small|normal |large| x-large
  isBold: true
}

```

Your JSON payload should be as follows:

```js
let jsonData = {
      data: {
          printData: [
            {
              type: "image",
              data: "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",
              alignment: "center"
            },
            {
              type: "text",
              data: "Tebogo Legodi",
              alignment: "center",
              size: "normal",
              isBold: true
            }
          ]
          }
      }
```
##### Example
```js
import {print} from 'react-native-n3-printer';

// Create a function to print receipt
async print(){

    let jsonData = {
      data: {
          printData: [
            {
              type: "image",
              data: "R0lGODdhNALqAPAAAAAAAP///ywAAAAANALqAAAC/4yPqcvtD6OctNqLs968+w+G4kiW5ol2wMq2bQrH8kzX9o3nOur2/rsLCofEovGITB5+zCZACY1Kp9Sq1cScZK/crvcLDsN8mq34jE6r19Tex8yOy+f0etlFgtv3/L4fjMfz80dYaHiYAySjh9jo+AgJEWjDGGl5ibk3mTiY6fkJCqgoVBlqeop644bUmer6CitCFtUaa3uL2zDbtpvr+4taW1UKXGxcSMzbe8zcTNeEluw8TT0s3QVdrb0NlS3n9MQtPq7q/Qy+Sa6+vuH0h27OLj+fAG4ID0+vP27fiP+/Yp9AY/0eATzIYqDCVOgwIXwYcKHESA0/QYQ4MeO9gv+gLiLUCFJTxWAe/4U8ySZfrJL4ULoUo/IWS44va1qjKXPmNZs8g8QspnNZz6FDfh4LOoqoUh1GmSGNuDQqpZHakEq9OqNp1ZlYuwrCKY6l17GyqMrzSDatCrP0MKp9e0GrvoNw61Jgu9Ck3b0O8E70y5cv4IzuAhteUphnvMN2wb4UxhjuYJerIjdOHDWd5bSOh2re7LWz56Sgu2I2nbD02NNYP6tWyrp16tdXF4eeTRu27dtQc4/embm3b8XApeIeXnM3WdLITxYP8LEEXYPCmzuH3Hd6Hu2ImFsnjF0X97IAIR3/rjG8+PLSxx86j17ic+juQUSnHi4+eKEP7o//8O9PdfoNpN56em3Hnnn5DZgXf/3V9waEGy3IoEAFMgBgCBl2J2CF8zj4YIL/SYhMhx6yA2J2IpJ3oIInEljZXSRysCGHFL64TooqtshiS5bAhyM/Mcq4ooYzEgJkkNzoaKCPCPLoSJJKbuVdBBmKpkCN75k4ZTVDEnngkfQVWQ+ZCIiJYJc5umbldG41KRdiUJY55xhcqukMm20+FZucdfoZpwFojngjnl5WuSefymkpqJmABorFnYYSpKckijrG6JhOYjiokYVO2kylll4aW6YzZtrep6AehWiipGJnqqONyhrpqtuIGuKrjMT656y9pmorlapqoetivG66AKqE/wZ7qKSjFivUsZAqSx6z1LTqKrTpSDsZtZ5aO42UxGq7DLdYehvhsODigm225Apnbp+PTrbsuk6JK8G75Z5KK7oe4GsvLAC729SbviKbZb+drqVuwCs5SzCmD53J76/+0gixwwxlnOufE897rsK0VqsxMANHrJymLcabssqQfluyyRx3HOjHB08rMsInnBxzKDzTPJjNLneb88sw98zuzECHLCLL0lycwc9IZyL1jjpT3HTFV4MsL8lT59QwmFvfTJXTF0KNQdVfKxi22DhnXTTRI/+r9NoU1W312ytrrffY9uFtd4CAcxp32XzL/Wu6gQs8OOEWc2e2jmhXoPbiNv/22PdPkX9JZ+IMW+5K5XkjvunmnJNNL8Ztg842ob0KbTqbQqfJOkmrux20f7FXOXu9tfvcOJy5Q344YL0f/XtHwTvuse7F42Ww78lbtHyyNc4uFtbjXbRz9dN/433CG2KfPerkRnr790iG3/l93Gv/vvnaoq8+9enj/m77But7Ot331y+S/42Lf/Aq39DyRzsAXkJ0z+Kf+NDCtfklUIF3E2C+CFgdrkQQWsCiYAW7h8EHxk9+xZqgB6PEPhEiUIUAwmAKZ3XCD6JPX8LbngtNGMMJfWWFzLtSCL2Ww8uBkIfWG+EGSSW9IOpwiBxEmV9KcsCuRe2FSrxJCoi4tDj/vW9hF7RgFc/AwC6aBG3HO2IvuLinL27Ji/iDg9+ciKsocm5uFgijGrFBRde1Ky5xHF0S7HhHLgCyNnkMpBIGSQ42Eq4chTRkEXvSxzRmBUue6l8Ue4bIsOyxi4t4Y96yOLpGNieTS9qkJK9IxyIiihgtsxUpSznIV/bQaCwcVimk6EpR5smUIbIT1NRTqlauSpbCUqScfIlGYBpLmKAiphidhas4nieSDczVwfyHzGRakjW4HKYuZ3kcw3GkIN7QzCSWSUlOonJfMcpGweIxTj3EhJmr+ab+OuGkfLqjIV8KRDxTd8oZfmYWQamlIioyT34CVDbG5GM/9ALRfSp0/5ovUInnRpVNIJHBKvc8pz3G+JTAOLOGgyhPRBUFP5N6EqPrdE0JU0rQkPJJpPZMqU3x6YZdbLQVlRGnO3PqUWousqV7nClMV+FCNEKypvDTn8ucOiSgbispUu0NHtp5GkuKMaPhcGBHkwrFyzS0jlS9qjkrOlW0lpU0ZgVCVW/ETV6qkqgJid/YdGVG9lyIoZyQKFvVmsG2BvavdfWnW6OnMtVx9QnnIyldzli6ySWHqV99K1wBe1nMqlCE17RskYTaucXKkXsgelVl05pK3YzVoR89a2Epqlmnto+EjDViYu/wzZK2NqyqNOq8hnba+fyGkROFbUBc+9rBGrerP/9FLGi1x1Xa6iSU0z1qVCU72dVSrqeCVW5tl/td72YWKs0VVz/l2tQdHval4KxuXoO7V0ISt4CYHW946Ztc+9o3goCimWzThl6ynu5SfvwIO7OKXcpQ9lFQRe1xHXzfzdrUfBP201MrzFrtttegWi1QTHXrUwRr9cK8wQF3u5uanSLVsPD58Chq4eKIqPi5JBboipGFYhPhNMblnHE4D8xcGqdnwXl9sEV9NFCjwLglF+1tDOYX1xtLOaTWzUJ8bTLSLPq4MCft0DsJy+WVOnmxXj0q6orsHvfy1cT50OdIXAqWOZKTlhKm65HVfGaySbe4LTYgITUsYL9iRnOrvCX/73a10P/a+aEFvWdoQTZaFjNHg6gBNIBVdeMxB/jR/mvYputMZiCHGTJMOuCef9tbQWd5TZbWo6c/HUBYX9o2IUYuwHg66P69ecRLbTXmqqk8Ibej1Cni9d9krWdHL8fXlZSUsOtw5cc8e8hTGPG051BqLF/7L0QOdNi2HYdsZ7fbtyL3diGGbPAZm810brae6NmxJ68bbJuJ9lSUmmFYpbMI8LaFudsi7nsnGI7iDTgp+s04Zg/Z4DSAoI2F0e6DC/cVq+Y2wzvp8CfBM9ESv3jCGTNxefPW1Uvm+A666YuKKyTkIs845nAd8ZMj/GEKl4+9a0Dpr7aRx4b2uJwd/4TylP87kTdvuJ9pCdIvo3NvUS66v1U+F5aHOsjmGFnSa51rvTLd6U+vuYWkrt7rbqGMaNa6dgycoKDLzOtR5/rUTxvpp6HULWh308yTxvYP3f3tVb6vo5BIWgmqfe11Gfwk5Ung9kIRLY01/C+gzmq3L/rHKFU84wN/dbN7XOhD3yXYmSjq+ub40A5UNW93vHnO511In3/4WqMjLwKSMNLwLS+4ab56WEo+7BB2szJpGPelw373j0/31/c+efymfTeX3/JBERv8sRO/+JC/luNbHvqE/l6mZrBt9FFv/FykHkbI5/2LodHj7Tf2+0m267ybFf7It17jWKX7oqyMfv+b5V/fmH+/9cevd9eXfI0We/hnVKY3acxUfkCxgPIHgK5XZnC3fxFYds83f9TXgLp3gSRHgX0nRx/YfPx3dhm4dvsWgCTIgY/lffJDYSDYfwOmfxuIgTGnSQI4gEwGffyVZ7bXZbr2MShYgk2mgTJ4bA5HdiyoZVSneT44fNN3L0fIejYIejZkddeQGO6TDBMjhZ63gjW4halyPFVohYhHaHLXg/43hDkIf0Dobi+zUK0kfCJobUrmhFzoZ2tIhC9HYw8IerzHG42Gh3XoSHyQeKFicoOIQoXIgCaIiBWEREGYh41oB00ENl8oiSVCiRR3iJfINpl4CpvIiY7oiZ7QQIOhuEDAR4qMaIrAs36naImr+COtmIhsCIup+IiCE4m1aDuAuD60qIvid4eT6Iu/+IT4JkjDSIzF9Ip/hIzJ6IC3VxS56IzHh4aHJIjTCBLSiHHViI1EoY1T2HndqA7fSHLiWBrk2GnhaI77gI5TVH3rqGB8WEnwGB/t+Cz0yCD2yFn46CH6eFv8+CLkyI0ASRu5OJAEmRsoeJAIiRzIJ48M2ZDP4Y8QCXJN95AUOSAjh5GYJGYb6ZEfCZIhKZIjSZIlaZIniZIpqZIrmRYFAAA7",
              alignment: "center"
            },
            {
              type: "text",
              data: "Tebogo Legodi",
              alignment: "center",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "SUPPLIER PAYMENT",
              alignment: "center",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "MERCHANT RECEIPT",
              alignment: "center",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Date          : 08 / 10 / 2021 15: 32",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "LDP Name      : LDP Katlehong",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "LDP Payer No  : 9847354",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Outlet Acc No : 12345",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Tebogo Legodi",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Invoice No    : 3660619401970",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Banking Ref   : 9847354BDF1000",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Driver Cell No: 0761385893",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Cashier       : Supervisor",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Transaction ID: 3795993278",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "BLD Account No: EEE200284",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Amount Paid   : R 250.00",
              alignment: "left",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "Support: Call on 0800 014 949, or WhatsApp 011 568 9055",
              alignment: "center",
              size: "normal",
              isBold: true
            },
            {
              type: "text",
              data: "---Print Done Done----",
              alignment: "center",
              size: "normal",
              isBold: true
            },

          ]
      }
    }

    const results = await print(JSON.stringify(jsonData));
  }
```


## Usage (Get Serial Number)
```js
import {getSerialNumber} from 'react-native-n3-library';

//Method to get Serial No
async getSerialNo(){
    let serialNo = await getSerialNumber();
    ToastAndroid.show(`${model}: ${serialNo}`, ToastAndroid.LONG);
  }
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
