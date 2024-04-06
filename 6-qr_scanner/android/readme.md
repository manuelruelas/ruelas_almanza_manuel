# QR Scanner app

<img src="https://github.com/manuelruelas/ruelas_almanza_manuel/assets/25523918/adb1e56b-6553-44bc-807a-2977a70d865e" height=400px />




## Requirements
- Android studio Electric eel

## Run & Debug
- Use physical device
- Tap in Run or Debug button
- Press scan button
  
`NOTE: You can generate QRCodes here [https://es.qr-code-generator.com/](https://es.qr-code-generator.com/) `


## Functionality
1. Scan Qr code using the device camera
2. Save locally the scanned codes
3. Show scanned codes list

## Architecture

The architecture is a simplified MVVM to avoid over-engineering.


![Captura de pantalla 2024-04-05 a la(s) 10 52 05 p m](https://github.com/manuelruelas/ruelas_almanza_manuel/assets/25523918/e30b7c49-ecd4-4fff-9f54-fa420b4106e7)


## Technologies
- LiveData: To update all the listeners on every view model change.
- Room: To persist data locally
