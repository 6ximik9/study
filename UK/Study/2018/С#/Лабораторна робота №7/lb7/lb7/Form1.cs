using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace lb7
{
    public partial class Form1 : Form
    {
        int[] Q = new int[20];
        public Form1()
        {
            InitializeComponent();
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            lstBox1.Items.Clear();
            Random rand = new Random();
            for (int i=0; i<20;i++)
            {
                Q[i] = rand.Next(0, 30);
                lstBox1.Items.Add("Q[" + i.ToString() + "] =" + Q[i].ToString());
            }
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            lstBox2.Items.Clear();
            for (int i = 0; i < 20; i++)
            {
                 if(Q[i]%7== 1|| Q[i] % 7 == 2 || Q[i] % 7 == 5)
                    lstBox2.Items.Add("Q[" + Convert.ToDouble(i) + "] =" + Q[i].ToString());
            }
        }
    }
}
