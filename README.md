# Lernperiode-9
**20.02.2026 - 27.03.2026**

## Project Overview
In this learning period, I aim to build a **web-based Minecraft PvP Guide**.  
For the tech stack, I chose:

- **Backend:** Kotlin with the Ktor framework (providing a RESTful API)  
- **Frontend:** JavaScript with React  

The website should eventually provide:

- PvP guides for different combat styles  
- Interactive tools like CPS tests and aim trainers  
- Possibly user accounts and progress tracking  
- **An appealing, user-friendly design that is visually engaging but not overcomplicated**

---

## 20.02.2026 – Exploring Ktor & React

**Goals**

- [ ] Work through the official Ktor REST API tutorial ([link](https://ktor.io/docs/server-create-restful-apis.html#prerequisit))  
- [ ] Understand how to set up a minimal Ktor backend for a RESTful API  
- [ ] Learn basic routing and JSON responses in Ktor  
- [ ] Set up a basic React project and learn how components and state work ([React Official Tutorial](https://react.dev/learn))  
- [ ] Connect the React frontend to Ktor REST API via a simple GET request  

**Report**

Today I worked on my Ktor backend for the Minecraft PvP Guide project. I’m following the official Ktor REST API tutorial ([link](https://ktor.io/docs/server-create-restful-apis.html#content-negotiation)), and I’ve reached the chapter on **Content Negotiation**.  

I started with a project generated on [start.ktor.io](https://start.ktor.io), so all the files like `Application.kt` and the default test file were already there. I didn’t have to create anything from scratch.  

At first, I ran into some Gradle build issues. I got errors like:

```
Unable to load class 'org.gradle.util.VersionNumber'
```
