import asyncio
from azure.servicebus.aio import ServiceBusClient

NAMESPACE_CONNECTION_STR = "Endpoint=sb://sb-ups-tacuri.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=uDCponH91n1y0L+xUNPlHzekoDWHyq4b0+ASbDptZjQ="
QUEUE_NAME = "ups"


async def run():
    async with ServiceBusClient.from_connection_string(
            conn_str=NAMESPACE_CONNECTION_STR,
            logging_enable=True) as servicebus_client:
        async with servicebus_client:
            receiver = servicebus_client.get_queue_receiver(queue_name=QUEUE_NAME)
            async with receiver:
                received_msgs = await receiver.receive_messages()
                for msg in received_msgs:
                    print("Mensaje: " + str(msg))
                    await receiver.complete_message(msg)

asyncio.run(run())
