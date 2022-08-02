import App from 'components/App';
import { QueryClient, QueryClientProvider } from "react-query";

function AppWrapper() {
    const queryClient = new QueryClient({
        defaultOptions: {
            queries : {
                refetchOnWindowFocus : false
            }
        }
    });

    return (
        <QueryClientProvider client={queryClient}>
            <App/>    
        </QueryClientProvider>
    )
}

export default AppWrapper;