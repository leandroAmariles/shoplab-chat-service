# shoplab-chat-service

Orquestador conversacional de **ShopLab Helpdesk** extraído del monolito en **LAB-59**.

## Responsabilidades
- Streaming SSE de respuestas (`POST /api/chat`) con citas RAG contra `retrieval-service` (LAB-129).
- Conversación de cortesía acotada (LAB-114) y memoria multi-turno en PostgreSQL (`chat.conversation_turn`, LAB-24).
- Valoración de respuestas y promoción a dataset golden (`PUT /api/chat/feedback/{turnId}`, `GET /api/chat/feedback`, `POST /api/chat/feedback/{turnId}/promote`, LAB-33).
- Instantánea de configuración del asistente (`GET /api/assistant/settings`) consumida por `eval` con contrato en `shoplab-contracts` y stubs Spring Cloud Contract.
- Gestión de prompts versionados (LAB-85) y trazas OTLP en Langfuse (LAB-64), y generación de modelos a través de LiteLLM (LAB-84).

## Verificación local
```bash
./mvnw -s .mvn/ci-settings.xml verify
```
