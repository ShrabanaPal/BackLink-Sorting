import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import api from "../api/axios";

export default function DetailsPage() {

  const { domain } = useParams();
  const [data, setData] = useState({});

  useEffect(() => {
    api.get(`/link/${domain}`).then(res => setData(res.data));
  }, []);

  return (
    <div className="bg-slate-900 p-6 rounded-xl">

      <h1>{domain}</h1>

      <a href={data.signInUrl}>Sign In</a>
      <br />
      <a href={data.signUpUrl}>Sign Up</a>

      <p className="mt-4">{data.strategy}</p>

    </div>
  );
}