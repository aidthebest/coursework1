FROM node:erbium-alpine3.12
WORKDIR /opt/app
COPY . .
RUN sudo apt install npm
CMD ["npm", "start"]
EXPOSE 9999